package dao;

import model.Worker;
import java.util.List;


public interface WorkerDAO {
    public int add(Worker worker);
           

    public void delete(int workerId);
            

    public Worker getWorker(int workerId);
            

    public List<Worker> getWorkers();
            

    public void update(Worker emp);
            
}
