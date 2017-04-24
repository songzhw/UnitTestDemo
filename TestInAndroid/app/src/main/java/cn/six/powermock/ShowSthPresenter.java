package cn.six.powermock;

public class ShowSthPresenter {
    public String value;


    public void sendTask(int id){
        TaskUtils.sendTask(id, getCallback());
    }

    private ITaskCallback getCallback(){
        return new ITaskCallback(){

            @Override
            public void onSucc(String str) {
                value = str;
            }

            @Override
            public void onFail(int error) {
                value = ""+error;
            }
        };
    }
}