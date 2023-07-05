package fr.swiftfaze.brink.business.service;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

@Service
public class GitService {

    private static final Logger logger = LoggerFactory.getLogger(GitService.class);
    CredentialsProvider provider = new UsernamePasswordCredentialsProvider("root", "glpat-xwBrzp_5FzzmhBy1xHCr");
    private final String remote = "http://192.168.1.28";

    public Git initRepository(String repoPath, String abletonXmlProjectFile) {
        try {


            String remoteUrl = this.remote + repoPath + ".git";


            Git git = Git.init().setDirectory(new File(repoPath)).call();


            File file = new File(git.getRepository().getDirectory().getParent(), "project" );
            file.createNewFile();
            Files.write(file.toPath(), abletonXmlProjectFile.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);

            git.add().addFilepattern(".").call();



            // Commit the changes
            PersonIdent author = new PersonIdent("Rob", "rob@example.com");
            git.commit().setAll(true).setMessage("init").setAuthor(author).call();




            // Push to the remote repository on the "develop" branch
            PushCommand pushCommand = git.push();
            pushCommand.setRemote(remoteUrl);
            pushCommand.setCredentialsProvider(provider);
            pushCommand.call();

            return git;
        } catch (GitAPIException | IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void stuff() {
//                        Repository newlyCreatedRepo = FileRepositoryBuilder.create(
//                    new File("/tmp/new_repo/.git"));
//            newlyCreatedRepo.create();


//            Git git = Git.cloneRepository()
//                    .setURI("http://192.168.1.28/brink/test.git")
//                    .setDirectory(new File("brink/test5"))
//                    .setCloneAllBranches(true)
//                    .setCredentialsProvider(provider).call();
//


//

//
//
//
//            git.push()
//                    .setRemote("http://192.168.1.28/brink/test22.git")
//                    .setCredentialsProvider(provider).call();
//



    }


    public void pushAbletonProject(Git git, String repoPath, String fileContents) {
        try {

            // Create a new branch called "develop" and checkout to it
            git.branchCreate().setName("develop").call();
            git.checkout().setName("develop").call();

            File file = new File(git.getRepository().getDirectory().getParent(), "project.txt" );
            file.createNewFile();
            Files.write(file.toPath(), fileContents.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);

            git.add().addFilepattern(".").call();






            // Commit the changes
            PersonIdent author = new PersonIdent("Rob2", "rob@example.com");
            git.commit().setAll(true).setMessage("project setup").setAuthor(author).call();

            String remoteUrl = this.remote + repoPath + ".git";



            // Push to the remote repository on the "develop" branch
            PushCommand pushCommand = git.push();
            pushCommand.setRemote(remoteUrl);
            pushCommand.setCredentialsProvider(provider);
            pushCommand.call();

        } catch (GitAPIException | IOException e) {
            throw new RuntimeException(e);
        }
    }



}
