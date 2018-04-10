/*                     __                                               *\
**     ________ ___   / /  ___      __ ____  Scala.js sbt plugin        **
**    / __/ __// _ | / /  / _ | __ / // __/  (c) 2013, LAMP/EPFL        **
**  __\ \/ /__/ __ |/ /__/ __ |/_// /_\ \    http://scala-js.org/       **
** /____/\___/_/ |_/____/_/ | |__/ /____/                               **
**                          |/____/                                     **
\*                                                                      */


package org.scalajs.sbtplugin.cross

import sbt._

@deprecated(
    "The built-in cross-project feature of sbt-scalajs is deprecated. " +
    "Use the separate sbt plugin sbt-crossproject instead: " +
    "https://github.com/portable-scala/sbt-crossproject",
    "0.6.23")
final class CrossClasspathDependency(
    val project: CrossProject,
    val configuration: Option[String]
) {
  def jvm: ClasspathDependency = ClasspathDependency(project.jvm, configuration)
  def js: ClasspathDependency = ClasspathDependency(project.js, configuration)
}

@deprecated(
    "The built-in cross-project feature of sbt-scalajs is deprecated. " +
    "Use the separate sbt plugin sbt-crossproject instead: " +
    "https://github.com/portable-scala/sbt-crossproject",
    "0.6.23")
object CrossClasspathDependency {
  final class Constructor(crossProject: CrossProject) {
    def %(conf: Configuration): CrossClasspathDependency = %(conf.name)

    def %(conf: String): CrossClasspathDependency =
      new CrossClasspathDependency(crossProject, Some(conf))
  }
}
