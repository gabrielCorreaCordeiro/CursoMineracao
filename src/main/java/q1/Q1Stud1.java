/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

import org.repodriller.RepoDriller;
import org.repodriller.RepositoryMining;
import org.repodriller.Study;
import org.repodriller.filter.range.Commits;
import org.repodriller.persistence.csv.CSVFile;
import org.repodriller.scm.GitRemoteRepository;
import org.repodriller.scm.GitRepository;


/**
 *
 * @author a1763954
 */
public class  Q1Stud1 implements Study{
    public static void main(String[] args) {
        new RepoDriller().start(new Q1Stud1() );
    }
    @Override
    public void execute() {
       new RepositoryMining()
               .in(GitRemoteRepository.hostedOn("https://github.com/canadaduane/house.git")
               .buildAsSCMRepository())
               .through(Commits.all())
               .process(new CommitVisitor(),new CSVFile("path"))
               .mine();
               
               
               
               
    }
    
}
