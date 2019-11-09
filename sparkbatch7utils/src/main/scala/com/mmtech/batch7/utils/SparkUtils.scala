package com.mmtech.batch7.utils

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object SparkUtils {


  def sparkConf(): SparkConf = {
    val sparkConf = new SparkConf().setAppName("SparkConf").setMaster("local[*]");
    return sparkConf;
  }

  def sparkContext(): SparkContext = {
    val sparkContext = new SparkContext(sparkConf());
    sparkContext.setLogLevel("ERROR")
    return sparkContext;
  }


  def sparkSession(): SparkSession = {
    val ss: SparkSession = SparkSession.builder().config(sparkConf()).getOrCreate();
    return ss;
  }

  def main(args: Array[String]): Unit = {

    val context = sparkContext();
    println("context :" + context)
    val sparkSessionObject = sparkSession();
    println("SparkSession =>" + sparkSessionObject)
    println("SparkSession getClass=>" + sparkSessionObject.getClass)
    //println(sparkSession.getClasss())
  }
}
