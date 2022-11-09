package com.r4u;

import com.amazonaws.auth.*;

public class SimpleAWSCredentials implements AWSCredentials {

	 @Override
	    public String getAWSAccessKeyId() {
	        return "wrong";
	    }

	    @Override
	    public String getAWSSecretKey() {
	        return "very_wrong";
	    }

}
