package com.granium.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service
import java.io.InputStream
import java.util.*
import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider
import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.auth.profile.internal.Profile
import com.amazonaws.regions.Region
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import java.awt.Color
import java.awt.Font
import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.OutputStream

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO

@Service
class AmazonS3ServiceImpl : AmazonS3Service {

  private val IMAGES_FOLDER = "images/"
  private val AMAZON_S3_URL = "https://s3.eu-central-1.amazonaws.com/"

  @Value("\${amazon.s3.bucket-name}")
  private lateinit var BUCKET_NAME: String

  @Value("\${amazon.s3.accessKey}")
  private lateinit var ACCESS_KEY: String

  @Value("\${amazon.s3.secretKey}")
  private lateinit var SECRET_KEY: String

  private val WATERMARK = "Berlusconi"
  private lateinit var amazonClient: AmazonS3

  @PostConstruct
  fun initializer() {
    amazonClient = AmazonS3Client(BasicAWSCredentials(ACCESS_KEY, SECRET_KEY))
    amazonClient.setRegion(Region.getRegion(Regions.EU_CENTRAL_1))
  }


  override fun saveCategoryImage(filename: String, stream: InputStream): String {
    var format = filename.split(".").last()
    if (format.equals(filename) || format.isEmpty()) format = "png"
    val newFileName = UUID.randomUUID().toString()
    amazonClient.putObject(BUCKET_NAME, "$IMAGES_FOLDER$newFileName.$format", stream, ObjectMetadata())
    return "$AMAZON_S3_URL$BUCKET_NAME/$IMAGES_FOLDER$newFileName.$format"
  }

  override fun saveAttachmentImage(filename: String, stream: InputStream): String {
    val image = watermark(stream)
    var format = filename.split(".").last()
    if (format.equals(filename) || format.isEmpty()) format = "png"
    val newFileName = UUID.randomUUID().toString()
    amazonClient.putObject(BUCKET_NAME, "$IMAGES_FOLDER$newFileName.$format", image, ObjectMetadata())
    return "$AMAZON_S3_URL$BUCKET_NAME/$IMAGES_FOLDER$newFileName.$format"
  }

  override fun deleteImage(url: String) {
    if(url.isEmpty()) return
    val objectKey = url.removePrefix(AMAZON_S3_URL + BUCKET_NAME + "/")
    amazonClient.deleteObject(BUCKET_NAME, objectKey)
  }

  private fun watermark(stream: InputStream): InputStream {
    val srcImage = ImageIO.read(stream)
    val width = srcImage.getWidth(null)
    val height = srcImage.getHeight(null)
    val destImage = BufferedImage(width, height,
        BufferedImage.TYPE_INT_RGB)
    val g = destImage.graphics
    g.drawImage(srcImage, 0, 0, width, height, null)
    g.color = Color(255, 255, 255, 100)
    g.font = Font("Arial", Font.BOLD, 26)
    g.drawString(WATERMARK, width / 2, height / 2)
    g.dispose()
    val os = ByteArrayOutputStream()
    ImageIO.write(destImage, "png", os)
    val fis = ByteArrayInputStream(os.toByteArray())
    return fis
  }

}