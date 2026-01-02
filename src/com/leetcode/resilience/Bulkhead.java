
    private static final ExecutorService bulkheadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + ": Processing request");
            try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        };

        for (int i = 0; i < 5; i++) {
            try {
                bulkheadPool.submit(task);
            } catch (RejectedExecutionException e) {
                System.out.println("Request " + i + ": Rejected by bulkhead");
            }
        }

        bulkheadPool.shutdown();
    }

