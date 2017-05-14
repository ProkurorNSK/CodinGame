package BotProgramming.Code4Life;

import java.util.*;

/**
 * Bring data on patient samplesCloud from the diagnosis machine to the laboratory with enough molecules to produceMedicines medicine!
 **/
class Player {

    private String target;
    private int eta;
    private int score;
    private int storageA;
    private int storageB;
    private int storageC;
    private int storageD;
    private int storageE;
    private int expertiseA;
    private int expertiseB;
    private int expertiseC;
    private int expertiseD;
    private int expertiseE;
    private ArrayList<Sample> samples;

    private static int availableA;
    private static int availableB;
    private static int availableC;
    private static int availableD;
    private static int availableE;
    private static Player player;
    private static Player enemy;
    private static ArrayList<Sample> samplesCloud;

    private final static int MAX_CARRY_SAMPLE = 3;
    private final static int MAX_CARRY_MOLECULES = 10;

    private Player(String target, int eta, int score, int storageA, int storageB, int storageC, int storageD, int storageE, int expertiseA, int expertiseB, int expertiseC, int expertiseD, int expertiseE) {
        this.target = target;
        this.eta = eta;
        this.score = score;
        this.storageA = storageA;
        this.storageB = storageB;
        this.storageC = storageC;
        this.storageD = storageD;
        this.storageE = storageE;
        this.expertiseA = expertiseA;
        this.expertiseB = expertiseB;
        this.expertiseC = expertiseC;
        this.expertiseD = expertiseD;
        this.expertiseE = expertiseE;
        samples = new ArrayList<>();
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int projectCount = in.nextInt();
        for (int i = 0; i < projectCount; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            int e = in.nextInt();
        }

        // game loop
        while (true) {
            for (int i = 0; i < 2; i++) {
                String target = in.next();
                int eta = in.nextInt();
                int score = in.nextInt();
                int storageA = in.nextInt();
                int storageB = in.nextInt();
                int storageC = in.nextInt();
                int storageD = in.nextInt();
                int storageE = in.nextInt();
                int expertiseA = in.nextInt();
                int expertiseB = in.nextInt();
                int expertiseC = in.nextInt();
                int expertiseD = in.nextInt();
                int expertiseE = in.nextInt();
                if (i == 0) {
                    player = new Player(target, eta, score, storageA, storageB, storageC, storageD, storageE, expertiseA, expertiseB, expertiseC, expertiseD, expertiseE);
                } else {
                    enemy = new Player(target, eta, score, storageA, storageB, storageC, storageD, storageE, expertiseA, expertiseB, expertiseC, expertiseD, expertiseE);
                }
            }
            availableA = in.nextInt();
            availableB = in.nextInt();
            availableC = in.nextInt();
            availableD = in.nextInt();
            availableE = in.nextInt();

            samplesCloud = new ArrayList<>();
            int sampleCount = in.nextInt();
            for (int i = 0; i < sampleCount; i++) {
                int sampleId = in.nextInt();
                int carriedBy = in.nextInt();
                int rank = in.nextInt();
                String expertiseGain = in.next();
                int health = in.nextInt();
                int costA = in.nextInt();
                int costB = in.nextInt();
                int costC = in.nextInt();
                int costD = in.nextInt();
                int costE = in.nextInt();
                switch (carriedBy) {
                    case 0:
                        player.samples.add(new Sample(sampleId, rank, expertiseGain, health, costA, costB, costC, costD, costE));
                        break;
                    case 1:
                        enemy.samples.add(new Sample(sampleId, rank, expertiseGain, health, costA, costB, costC, costD, costE));
                        break;
                    default:
                        samplesCloud.add(new Sample(sampleId, rank, expertiseGain, health, costA, costB, costC, costD, costE));
                        break;
                }
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            System.err.println("Player1: " + player.target + ": " + player.eta + ": " + player.score + ": " + player.storageA + ": " + player.storageB + ": " + player.storageC + ": " + player.storageD + ": " + player.storageE);
            System.err.println("Player2: " + player.expertiseA + ": " + player.expertiseB + ": " + player.expertiseC + ": " + player.expertiseD + ": " + player.expertiseE + ": " + player.samples);
            System.err.println("Enemy1: " + enemy.target + ": " + enemy.eta + ": " + enemy.score + ": " + enemy.storageA + ": " + enemy.storageB + ": " + enemy.storageC + ": " + enemy.storageD + ": " + enemy.storageE);
            System.err.println("Enemy2: " + enemy.expertiseA + ": " + enemy.expertiseB + ": " + enemy.expertiseC + ": " + enemy.expertiseD + ": " + enemy.expertiseE + ": " + enemy.samples);
            player.action(enemy);
        }
    }

    private void action(Player enemy) {

        System.err.println("Eta: " + eta + " : SmpCnt: " + samples.size() + " : SmpCloudCnt: " + samplesCloud.size() + " : hUndSmp: " + haveUndiagnosedSamples() + " : hProdOne: " + haveMoleculesForProduceOne() + " : hProdAll: " + haveMoleculesForProduceAll() + " : molCnt: " + getSumStorage());
        if (samples.size() < MAX_CARRY_SAMPLE && samplesCloud.isEmpty()) {
            inSamples();
        } else if (((samples.size() < MAX_CARRY_SAMPLE && !samplesCloud.isEmpty()) || haveUndiagnosedSamples()) && !haveMoleculesForProduceOne()) {
            inDiagnostic();
        } else if ((samples.size() == MAX_CARRY_SAMPLE || samplesCloud.isEmpty()) && getSumStorage() < MAX_CARRY_MOLECULES && !haveMoleculesForProduceAll()) {
            inMolecules();
        } else if (!samples.isEmpty()) {
            inLaboratory();
        } else {
            System.out.println("WAIT");
        }
    }

    private void inSamples() {
        if (target.equals("SAMPLES")) {
            System.err.println("inSamples");
            collectSamples();
        } else {
            System.err.println("toSamples");
            System.out.println("GOTO SAMPLES");
        }
    }

    private void inDiagnostic() {
        if (target.equals("DIAGNOSIS")) {
            System.err.println("inDiagnostic");
            analyzeSamples();
        } else {
            System.err.println("toDiagnostic");
            System.out.println("GOTO DIAGNOSIS");
        }
    }

    private void inMolecules() {
        if (target.equals("MOLECULES")) {
            System.err.println("inMolecules");
            gatherMolecules();
        } else {
            System.err.println("toMolecules");
            System.out.println("GOTO MOLECULES");
        }
    }

    private void inLaboratory() {
        if (target.equals("LABORATORY")) {
            System.err.println("inLaboratory");
            produceMedicines();
        } else {
            System.err.println("toLaboratory");
            System.out.println("GOTO LABORATORY");
        }
    }

    private void collectSamples() {
        System.out.println("CONNECT " + "1");
    }

    private void analyzeSamples() {
        if (!samplesCloud.isEmpty()) {
            samplesCloud.sort(new comparatorSample());
            System.out.println("CONNECT " + samplesCloud.get(0).id);
        } else if (haveUndiagnosedSamples()) {
            for (Sample sample : samples) {
                if (sample.getSumCost() < 0) {
                    System.out.println("CONNECT " + sample.id);
                    break;
                }
            }
        }
    }

    private void gatherMolecules() {
        samples.sort(new comparatorSample());
        System.err.println(samples);

        for (Sample sample : samples) {
            System.err.println("target - " + sample);
            if (haveMoleculesForProduce(sample)) {
                storageA -= sample.costA;
                storageB -= sample.costB;
                storageC -= sample.costC;
                storageD -= sample.costD;
                storageE -= sample.costE;
                System.err.println("haveForProduce, left - " + "a" + storageA + "b" + storageB + "c" + storageC + "d" + storageD + "e" + storageE);
            } else {
                if (storageA < sample.costA && availableA > 0) {
                    System.out.println("CONNECT A");
                } else if (storageB < sample.costB && availableB > 0) {
                    System.out.println("CONNECT B");
                } else if (storageC < sample.costC && availableC > 0) {
                    System.out.println("CONNECT C");
                } else if (storageD < sample.costD && availableD > 0) {
                    System.out.println("CONNECT D");
                } else if (storageD < sample.costE && availableE > 0) {
                    System.out.println("CONNECT E");
                } else {
                    System.out.println("WAIT");
                }
                break;
            }
        }
    }

    private void produceMedicines() {
        samples.sort(new comparatorSample());
        System.err.println(samples);
        for (Sample sample : samples) {
            if (haveMoleculesForProduce(sample)) {
                System.out.println("CONNECT " + sample.id);
                break;
            }
        }
    }

    private boolean haveMoleculesForProduceOne() {
        boolean result = false;
        for (Sample sample : samples) {
            if (sample.getSumCost() >= 0 && haveMoleculesForProduce(sample)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private boolean haveMoleculesForProduceAll() {
        int sumCostA = 0;
        int sumCostB = 0;
        int sumCostC = 0;
        int sumCostD = 0;
        int sumCostE = 0;

        if (!samples.isEmpty()) {
            for (Sample sample : samples) {
                sumCostA += sample.costA;
                sumCostB += sample.costB;
                sumCostC += sample.costC;
                sumCostD += sample.costD;
                sumCostE += sample.costE;
            }
            return sumCostA >= 0 && sumCostB >= 0 && sumCostC >= 0 && sumCostD >= 0 && sumCostE >= 0
                    && sumCostA <= storageA && sumCostB <= storageB && sumCostC <= storageC && sumCostD <= storageD && sumCostE <= storageE;
        } else {
            return false;
        }
    }

    private boolean haveUndiagnosedSamples() {
        boolean result = false;
        for (Sample sample : samples) {
            if (sample.getSumCost() < 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    private boolean haveMoleculesForProduce(Sample sample) {
        return sample.costA <= storageA && sample.costB <= storageB && sample.costC <= storageC && sample.costD <= storageD && sample.costE <= storageE;
    }

    private int getSumStorage() {
        return storageA + storageB + storageC + storageD + storageE;
    }

    static class Sample {
        int id;
        int rank;
        String expertiseGain;
        int health;
        int costA;
        int costB;
        int costC;
        int costD;
        int costE;

        Sample(int id, int rank, String expertiseGain, int health, int costA, int costB, int costC, int costD, int costE) {
            this.id = id;
            this.rank = rank;
            this.expertiseGain = expertiseGain;
            this.health = health;
            this.costA = costA;
            this.costB = costB;
            this.costC = costC;
            this.costD = costD;
            this.costE = costE;
            System.err.println(this);
        }

        @Override
        public String toString() {
            return "s" + id + "r" + rank + "g\"" + expertiseGain + "\"h" + health + "a" + costA + "b" + costB + "c" + costC + "d" + costD + "e" + costE;
        }

        int getSumCost() {
            return (costA + costB + costC + costD + costE);
        }
    }

    class comparatorSample implements Comparator<Sample> {

        @Override
        public int compare(Sample o1, Sample o2) {
            if (calculateWeight(o1) < calculateWeight(o2)) {
                return 1;
            } else if (calculateWeight(o1) > calculateWeight(o2)) {
                return -1;
            } else {
                return 0;
            }
        }

        int calculateWeight(Sample sample) {
            return sample.health - sample.getSumCost();
        }
    }
}