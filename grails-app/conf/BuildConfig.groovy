grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]



grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") 
    log "error" 
    checksums true
    legacyResolve false

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()

        mavenRepo name:'BertramLabs', root:'http://nexus.bertramlabs.com/content/repositories/snapshots'
        mavenRepo name:'BertramLabsRelease', root:'http://nexus.bertramlabs.com/content/repositories/releases'

    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
        runtime 'mysql:mysql-connector-java:5.1.24'
        // compile 'org.apache.activemq:activemq-core:5.3.0'
    }

    plugins {
        // plugins for the build system only
        build ":tomcat:7.0.52.1"

        // compile ":scaffolding:2.0.0"
        compile ':cache:1.1.1'

        // compile ":jms:1.2"
        compile ":profiler:0.5"

        // plugins needed at runtime but not for compilation
        runtime ":hibernate:3.6.10.10" 
        runtime ":database-migration:1.3.5"
        runtime ":jquery:1.11.0.1"
        runtime ":asset-pipeline:1.7.4"
        runtime ":less-asset-pipeline:1.7.0"
        runtime ":security-bridge:0.5.2"
        compile ":twitter-bootstrap:3.0.3"
    }
}

// grails.plugin.location."less-asset-pipeline" = "../../less-grails-asset-pipeline"
// grails.plugin.location."asset-pipeline" = "../../plugins/asset-pipeline"
// grails.plugin.location."retina-tag" = "../../plugins/retina-tag-grails"
// grails.plugin.location."karman" = "../../plugins/karman"
grails.plugin.location."spud-core" = "../spud-core"
grails.plugin.location."spud-security" = "../spud-security"
grails.plugin.location."spud-cms" = "../spud-cms"
// grails.plugin.location."spud-blog" = "../spud-blog"
grails.plugin.location."spud-permalinks" = "../spud-permalinks"

// grails.plugin.location."security-bridge" = "../../grails-security-bridge"
