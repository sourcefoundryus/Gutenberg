package us.sourcefoundry.gutenberg.factories;

import us.sourcefoundry.gutenberg.models.ApplicationContext;
import us.sourcefoundry.gutenberg.services.Cli;

public class ApplicationContextFactory {

    public ApplicationContext make(Cli cli){
        //Get some details about the system.
        String workingDir = System.getProperty("user.dir");
        String sourceDir = workingDir;

        //Get the input/source directory.
        if(cli.hasOption("i"))
            sourceDir = cli.getOptionValue("i");

        //Get the action specified by the user.
        String userSpecifiedCommand = (cli.getArgList().size() > 0  ? cli.getArgList().get(0).toString() : "");

        //Create an application context for use later in the process.
        ApplicationContext applicationContext = new ApplicationContext();
        applicationContext.setCommand(userSpecifiedCommand);
        applicationContext.setWorkingDirectory(workingDir);
        applicationContext.setSourceDirectory(sourceDir);

        return applicationContext;
    }
}
