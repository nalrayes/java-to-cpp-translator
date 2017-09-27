name := "class04"

version := "1.0"

scalaVersion := "2.11.7"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

unmanagedResourceDirectories in Compile += { baseDirectory.value / "src/main/java" }

resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.9"

//libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"

crossPaths := false

scalariformSettings
