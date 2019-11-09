package com.mmtech.batch7.sql.dataframe

import com.mmtech.batch7.utils.SparkUtils

object CSVReaderUtils {


  def main(args: Array[String]): Unit = {


    val df = SparkUtils.sparkSession().read
      .options(
        Map(
          "header" -> "true",
          "inferSchema" -> "true",
          "nullValue" -> "NA",
          "timestampFormat" -> "yyyy-MM-dd'T'HH:mm?:ss",
          "mode" -> "failfast"
        )
      )
      .csv("resources/survey.csv")

    df.printSchema()
    df.show(20, false)

    println("#############################################")

    println("df.rdd.getNumPartitions :" + df.rdd.getNumPartitions)

    println("#############################################")

    df.select("Timestamp", "Age", "remote_work", "leave").filter("Age > 30").show

    println("##########select($\"Gender\", $\"treatment\")####################")
    val df1 = df.select("Gender", "treatment")
    df1.show();

    println("#############################################")

    val df2 = df.select(
      "Gender",
      (when("treatment" === "Yes", 1).otherwise(0)).alias("All-Yes"),
      (when("treatment" === "No", 1).otherwise(0)).alias("All-Nos")
    )

  }
}
