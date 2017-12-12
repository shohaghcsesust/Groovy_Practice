
class ClosureTest {
	static main(args) {
		/**
		 * closure is an anonymous block
		 */
		def closure = { 
			param1 ->
			if(param1%2==0){
				println "Even number"
			} else {
				println "Odd number"
			}
		}
		closure.call(5)
		closure.call(6)
	}
}
