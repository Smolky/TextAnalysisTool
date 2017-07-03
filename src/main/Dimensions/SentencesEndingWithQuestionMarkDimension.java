package main.Dimensions;

/**
 * SentencesEndingWithQuestionMarkDimension
 * 
 * @todo. Maybe this methods does not work well
 * in Spanish texts
 * 
 * @author Jos� Antonio Garc�a D�az
 *
 */
public class SentencesEndingWithQuestionMarkDimension extends BaseDimension {
	
	/**
	 * process
	 */
	public double process () {
		if (this.getInput ().isEmpty()) {
			return 0;
		}
		
		// Get the number of sentences
		double result = 0;
		for (String sentence : this.getInput ().split("[!?.:]+")) {
			if (sentence.substring (sentence.length() - 1) == "?") {
				result++;
			}
		}
		return result;
				
	}

}
