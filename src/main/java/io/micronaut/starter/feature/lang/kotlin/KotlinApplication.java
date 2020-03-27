package io.micronaut.starter.feature.lang.kotlin;

import io.micronaut.starter.Project;
import io.micronaut.starter.command.CommandContext;
import io.micronaut.starter.command.CreateAppCommand;
import io.micronaut.starter.feature.ApplicationFeature;
import io.micronaut.starter.template.RockerTemplate;

public class KotlinApplication implements ApplicationFeature {

    @Override
    public String mainClassName(Project project) {
        return project.getPackageName() + ".Application";
    }

    @Override
    public String getName() {
        return "application";
    }

    @Override
    public boolean supports(String command) {
        return command.equals(CreateAppCommand.NAME);
    }

    @Override
    public void apply(CommandContext commandContext) {
        ApplicationFeature.super.apply(commandContext);

        commandContext.addTemplate("application", new RockerTemplate(getPath(),
                application.template(commandContext.getProject(), commandContext.getFeatures())));
    }

    protected String getPath() {
        return "src/main/kotlin/{packagePath}/Application.kt";
    }
}
