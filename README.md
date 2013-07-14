Services (SAR) in JBoss AS 7
================

Introduction
------------------------



Instructions:
------------------------

Prepare JBoss installation:
1.  Deploy Commons module
2.  Deploy Client and Service sar's
3.  $$$



* Deploy Commons:
mkdir -p $JBOSS_HOME/modules/pl/iogreen/jboss/common/main
cp module/pl/iogreen/jboss/common/main/module.xml $JBOSS_HOME/modules/pl/iogreen/jboss/common/main

* Deploy/Redeploy with Maven:
cd client
mvn jboss-as:deploy -Djboss-as.deployment.filename=client-1.sar
cd ../service
mvn jboss-as:deploy -Djboss-as.deployment.filename=service-1.sar

*  ... or copy to the $JBOSS_HOME/standalone/deployments folder