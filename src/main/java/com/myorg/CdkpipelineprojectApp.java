package com.myorg;

import software.amazon.awscdk.core.App;

import java.util.Arrays;

public class CdkpipelineprojectApp {
    public static void main(final String[] args) {
        App app = new App();

        new CdkpipelineprojectStack(app, "CdkpipelineprojectStack");

	CdkpipelineprojectStack.Builder.create(app, "PipelineStack")
            .env(new Environment.Builder()
                .account("919027951404")
                .region("ap-southeast-2")
                .build())
            .build();

        app.synth();
    }
}
