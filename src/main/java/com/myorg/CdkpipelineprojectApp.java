package com.myorg;

import software.amazon.awscdk.core.App;
import software.amazon.awscdk.core.Environment;

import java.util.Arrays;

public class CdkpipelineprojectApp {
    public static void main(final String[] args) {
        App app = new App();

	CdkpipelineprojectStack.Builder.create(app, "CdkpipelineprojectStack")
            .env(new Environment.Builder()
                .account("919027951404")
                .region("ap-southeast-2")
                .build())
            .build();

        app.synth();
    }
}
