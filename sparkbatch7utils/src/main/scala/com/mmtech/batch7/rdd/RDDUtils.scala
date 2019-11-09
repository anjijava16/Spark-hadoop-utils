package com.mmtech.batch7.rdd

import com.mmtech.batch7.utils.SparkUtils

object RDDUtils {

  def rddOperation(): Unit = {

    //Load the data file
    val sparkContext = SparkUtils.sparkContext();
    //val flistRDD = sparkContext.textFile("flist.txt")

    //Check the number of partitions
    // flistRDD.getNumPartitions
    //Redefine the partitions
    val flistRDD = sparkContext.textFile("flist.txt", 5)
    //The second parameter in the above API is the number of partitions.
    //Verify the new partitons
    //flistRDD.getNumPartitions
    //You can iterate to all partitions and count the number of elements in each partition.
    //flistRDD.foreachPartition(p => println("No of Items in partition-" + p.count(y => true)))
  }

  def main(args: Array[String]): Unit = {


  }
}
