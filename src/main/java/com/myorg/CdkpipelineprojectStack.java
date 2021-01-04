package com.myorg;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;

public class CdkpipelineprojectStack extends Stack {
    public CdkpipelineprojectStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public CdkpipelineprojectStack(final Construct scope, final String id, final StackProps props)
    {
        super(scope, id, props);

        final Artifact sourceArtifact = new Artifact();
        final Artifact cloudAssemblyArtifact = new Artifact();
        
        final CdkPipeline pipeline = CdkPipeline.Builder.create(this, "Pipeline")
                .pipelineName("MyAppPipeline")
                .cloudAssemblyArtifact(cloudAssemblyArtifact)
                .sourceAction(GitHubSourceAction.Builder.create()
                        .actionName("GitHub")
                        .output(sourceArtifact)
                        .oauthToken(SecretValue.secretsManager("GITHUB_TOKEN_NAME"))
                        .trigger(GitHubTrigger.POLL)
                        .owner("kullu-ashish")
                        .repo("https://github.com/kullu-ashish/cdkpipelineproject.git")
                        .build())
                .synthAction(SimpleSynthAction.standardNpmSynth(
                        StandardNpmSynthOptions.builder()
                            .sourceArtifact(sourceArtifact)
                            .cloudAssemblyArtifact(cloudAssemblyArtifact)
                            .buildCommand("npm run build")
                            .build()))
                .build();
    }
 
}
