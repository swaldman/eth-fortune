name := "eth-fortune"

version := "0.0.1-SNAPSHOT"

ethcfgScalaStubsPackage := "ethfortune.contract"

Test/ethcfgAutoSpawnContracts := Seq( "Fortune \"It will be okay.\"" ) // a bit ugly, because the string constructor argument must be quoted

libraryDependencies += "org.specs2" %% "specs2-core" % "4.0.2" % "test"






