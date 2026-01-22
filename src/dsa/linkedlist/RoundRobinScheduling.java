package dsa.linkedlist;

import java.util.Scanner;


class ProcessNode {
    int pid;
    int burstTime;
    int remainingTime;
    int waitingTime;
    int turnAroundTime;
    ProcessNode next;

    ProcessNode(int pid, int burstTime) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.waitingTime = 0;
        this.turnAroundTime = 0;
        this.next = null;
    }
}


class RoundRobinScheduler {
    private ProcessNode head;
    private ProcessNode tail;
    private int processCount;


    public void addProcess(int pid, int burstTime) {
        ProcessNode newNode = new ProcessNode(pid, burstTime);

        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        processCount++;
    }


    public void schedule(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int time = 0;
        ProcessNode current = head;

        System.out.println("\n--- Round Robin Execution ---");

        while (processCount > 0) {

            if (current.remainingTime > 0) {
                System.out.println("Process P" + current.pid + " executing...");

                int execTime = Math.min(timeQuantum, current.remainingTime);
                time += execTime;
                current.remainingTime -= execTime;


                updateWaitingTime(current, execTime);

                if (current.remainingTime == 0) {
                    current.turnAroundTime = time;
                    System.out.println("Process P" + current.pid + " completed.");
                    removeProcess(current.pid);
                }
            }

            current = current.next;
            displayQueue();
        }

        displayAverages();
    }


    private void updateWaitingTime(ProcessNode running, int execTime) {
        ProcessNode temp = head;

        do {
            if (temp != running && temp.remainingTime > 0) {
                temp.waitingTime += execTime;
            }
            temp = temp.next;
        } while (temp != head);
    }


    private void removeProcess(int pid) {
        if (head == null) return;

        ProcessNode temp = head;
        ProcessNode prev = tail;

        do {
            if (temp.pid == pid) {

                if (temp == head && temp == tail) {
                    head = tail = null;
                } else {
                    if (temp == head)
                        head = head.next;

                    if (temp == tail)
                        tail = prev;

                    prev.next = temp.next;
                }
                processCount--;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }


    private void displayQueue() {
        if (head == null) {
            System.out.println("Queue empty.\n");
            return;
        }

        ProcessNode temp = head;
        System.out.print("Current Queue: ");
        do {
            System.out.print("P" + temp.pid + "(" + temp.remainingTime + ") ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("\n");
    }


    private void displayAverages() {
        double totalWT = 0;
        double totalTAT = 0;

        System.out.println("\n--- Final Process Details ---");
        System.out.println("PID\tWT\tTAT");

        ProcessNode temp = head;
        if (temp == null) return;

        do {
            totalWT += temp.waitingTime;
            totalTAT += temp.turnAroundTime;
            System.out.println("P" + temp.pid + "\t" + temp.waitingTime + "\t" + temp.turnAroundTime);
            temp = temp.next;
        } while (temp != head);

        System.out.println("\nAverage Waiting Time: " + (totalWT / (totalWT == 0 ? 1 : totalWT)));
        System.out.println("Average Turnaround Time: " + (totalTAT / (totalTAT == 0 ? 1 : totalTAT)));
    }
}


public class RoundRobinScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter Burst Time for P" + i + ": ");
            int bt = sc.nextInt();
            scheduler.addProcess(i, bt);
        }

        System.out.print("Enter Time Quantum: ");
        int tq = sc.nextInt();

        scheduler.schedule(tq);
    }
}

