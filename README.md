### Занятие 12 Многопоточность. 
Реализовано через java.util.concurrent.locks.ReentrantLock<br>
<tr>
```
public void add(final Person person) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            checkCapacity();
            data[size++] = person;
        } finally {
            lock.unlock();
        }
    }
```
