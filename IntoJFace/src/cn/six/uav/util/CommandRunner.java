package cn.six.uav.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by songzhw on 2016/3/10.
 */
public class CommandRunner {

    private List<String> outputs;

    public int run(List<String> cmds) throws Exception {
        outputs = new ArrayList<>();
        ProcessBuilder procBuilder = new ProcessBuilder(cmds)
                                            .redirectErrorStream(true);
        final Process proc = procBuilder.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String line;
                outputs.clear();
                try {
                    InputStream is = proc.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    while( (line = reader.readLine()) != null){
                        outputs.add(line);
                    }

                    for(String aline : outputs){
                        System.out.println("szw line = "+aline);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }) .start();

        return proc.waitFor();
    }
}
