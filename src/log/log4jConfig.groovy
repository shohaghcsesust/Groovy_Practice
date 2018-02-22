package log

/*
 * Custom log4j configuration
 * @author Md.Ahsan Kabir/BJIT Ltd.
 * @date Feb 22, 2018
*/

log4j {
	appender.stdout = "org.apache.log4j.ConsoleAppender"
	appender."stdout.layout"="org.apache.log4j.PatternLayout"
	appender.scrlog = "org.apache.log4j.FileAppender"
	appender."scrlog.layout"="org.apache.log4j.TTCCLayout"
	appender."scrlog.file"="script.log"

	rootLogger="debug,scrlog,stdout"

	/** these don't do nothing but illustrate how to configure logging on packages
	logger.org.springframework="info,stdout"
	additivity.org.springframework=false
	**/
}