Example from http://www.lihaoyi.com/hands-on-scala-js/#IntegratingClient-Server

Run with `sbt appJVM/reStart`

It warns with:
```
The built-in cross-project feature of sbt-scalajs is deprecated.
Use the separate sbt plugin sbt-crossproject instead: https://github.com/portable-scala/sbt-crossproject
```

It fails with:
```
Application appJVM not yet started
[error] java.lang.RuntimeException: No main class detected!
```
