package Command;


import java.util.ArrayList;

/**
 * Created by zhouyu on 11/12/2016.
 * 具体命令
 */
public class ConcreteCommand implements Command
{
    ArrayList<String> dirNameList;
    MakeDir makeDir;
    ConcreteCommand(MakeDir makeDir)
    {
        dirNameList= new ArrayList<String>();
        this.makeDir=makeDir;
    }
    public void execute(String name)
    {
        makeDir.creatDir(name);
        dirNameList.add(name);

    }
    public void undo()
    {
        if(dirNameList.size()>0)
        {
            int m = dirNameList.size();
            String str = dirNameList.get(m - 1);
            makeDir.deleteDir(str);
            dirNameList.remove(m - 1);
        }

    }
}
