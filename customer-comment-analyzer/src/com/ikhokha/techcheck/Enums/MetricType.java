package com.ikhokha.techcheck.Enums;

/* All metric types have to be defined as a constant in the below enum
 * The enum is referenced when setting the metric type and when determining what metric type should be used to perform the analaysis
 * This approach enforces consistency
 */

public enum MetricType {
	MAX_LENGTH, //ENUM type to obtain lines that have at most N number of characters
	OCCURANCE_COUNTER,	//Enum type to obtain the number of occurences of a term
	OCCURANCE_COUNTER_WITH_REGEX
}
