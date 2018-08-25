# Scenario One: EDI DB to HL7 (Lab Orders from Hub to Lab System)

For this scenario, we consume database records from an Oracle database in Fuse, transform them into HL7 v2.4 messages with Trace Transformer, then push the HL7 messages to an HL7 server using the MLLP protocol.

#### Prerequisite installation steps

In order to run this example, a evaluation license must be obtained from [Trace Financial](https://www.tracefinancial.com/contact-us).  For the purpose of this example, Transformer version 3.6.9-SNAPSHOT is assumed.  Once the Transformer tooling has been downloaded, please execute the following steps to copy the required files to your local Maven repository:

1. Copy <transformer-install-dir>\runtime\3.6.9-SNAPSHOT\maven\transformer-runtime-skinny-3.6.9-SNAPSHOT.jar to a temp directory

2. Copy <transformer-install-dir>\runtime\3.6.9-SNAPSHOT\maven\transformer-runtime-skinny-3.6.9-SNAPSHOT.pom to a temp directory

3. Copy <transformer-install-dir>\lib\transformer-designtime-3.6.3.jar and <transformer-install-dir>\runtime\3.6.9-SNAPSHOT\currency-lib to a temp directory

4. Execute the following commands via the CLI to install the prerequisite JAR files in your local Maven repostiory:

```
mvn install:install-file -DgroupId=com.tracegroup.transformer -DartifactId=transformer-runtime-skinny -Dversion=3.6.9-SNAPSHOT -Dpackaging=pom -Dfile=transformer-runtime-skinny-3.6.9-SNAPSHOT.pom.xml

mvn install:install-file -DgroupId=com.tracegroup.transformer -DartifactId=currencylib -Dversion=1.0.10 -Dfile=currencylib-1.0.10.jar -Dpackaging=jar
```

5. Install the Trace Transformer sample project to your local Maven repository by executing the following command:

```
mvn install:install-file -DgroupId=com.tracefinancial.pocs -DartifactId=scenario1 -Dversion=0.2 -Dfile=scenario1-0.2.jar -Dpackaging=jar
```

### Running the example standalone with SpringBoot

The example can be demonstrated by running the following command:

    mvn spring-boot:run

### Running the example in OpenShift

It is assumed that:
- OpenShift platform is already running, if not you can find details how to [Install OpenShift at your site](https://docs.openshift.com/container-platform/3.3/install_config/index.html).
- Your system is configured for Fabric8 Maven Workflow, if not you can find a [Get Started Guide](https://access.redhat.com/documentation/en/red-hat-jboss-middleware-for-openshift/3/single/red-hat-jboss-fuse-integration-services-20-for-openshift/)

The example can be built and run on OpenShift using a single goal:

    mvn -P ocp

When the example runs in OpenShift, you can use the OpenShift client tool to inspect the status

To list all the running pods:

    oc get pods

Then find the name of the pod that runs this quickstart, and output the logs from the running pods with:

    oc logs <name of pod>

You can also use the openshift [web console](https://docs.openshift.com/container-platform/3.3/getting_started/developers_console.html#developers-console-video) to manage the
running pods, and view logs and much more.
