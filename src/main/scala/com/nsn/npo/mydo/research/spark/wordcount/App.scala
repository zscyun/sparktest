package com.nsn.npo.mydo.research.spark.wordcount

import org.apache.log4j.Level
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

/**
 * @author ${user.name}
 */
object App {

  //  def foo(x : Array[String]) = x.foldLeft("")((a,b) => a + b)
  //  
  //  def main(args : Array[String]) {
  //    println( "Hello World!" )
  //    println("concat arguments = " + foo(args))
  //  }
  Logger.getLogger("org").setLevel(Level.ERROR);

  def main(args: Array[String]) {
     val javaObj = new MyJavaTest()
    javaObj.sayHellow()
    
    val logFile = javaObj.testFilePath //"d://test.txt" // Should be some file on your system  
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
    
   
  }

}
