package log

/**
 * This script for Log4j configuration using to log
 * @author Md.Ahsan Kabir/BJIT Ltd.
 * @Date Feb 22, 2018
 */

@Grab('log4j:log4j:1.2.17')

import org.apache.log4j.*
import groovy.util.logging.*

@Log4j
class HelloWorld {
	def execute() {
		def config = new ConfigSlurper().parse(new File('log4jConfig.groovy').toURL())
		PropertyConfigurator.configure(config.toProperties())
		
		log.debug 'Excecute HelloWorld.'
		
		log.info 'Simple sample to show log field is injected.'
	}
}

def helloWorld = new HelloWorld()
helloWorld.execute()