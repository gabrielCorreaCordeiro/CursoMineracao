/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2;

import org.eclipse.jgit.lib.Repository;
import org.repodriller.RepoDriller;
import org.repodriller.RepositoryMining;
import org.repodriller.Study;
import org.repodriller.filter.commit.OnlyInMainBranch;
import org.repodriller.filter.range.Commits;
import org.repodriller.persistence.csv.CSVFile;
import org.repodriller.scm.GitRepository;

/**
 *
 * @author a1763954
 */
public class Q2Study implements Study{
   
    public static void main(String[] args) {
        new RepoDriller().start(new Q2Study());
    }
 
    @Override
    public void execute() {
        new RepositoryMining()
               .in(GitRepository.singleProject("path"))
                .through(Commits.all())
                .filters(new OnlyInMainBranch())
                .process(new BugVisitor(),new CSVFile("path"))
                .mine();
    }
    
}
