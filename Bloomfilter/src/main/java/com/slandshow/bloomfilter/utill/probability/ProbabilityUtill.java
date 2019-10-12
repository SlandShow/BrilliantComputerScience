package com.slandshow.bloomfilter.utill.probability;

public class ProbabilityUtill {

    /**
     * Calculate false probability using formula: 1-e^(-ln(2)² * m/n).
     *
     * @param k number of hash functions.
     * @param n size of Bloom filter array.
     * @param m number of elements in Bloom filter.
     *
     * @return probability of false positives.
     */
    public static double calculateFalseProbability(int k, int n, int m) {
        return 1 - Math.exp(-(Math.pow(Math.log(2), 2)) * m / n);
    }

    /**
     * Check if false probability is low.
     *
     * @param k number of hash functions.
     * @param n size of Bloom filter array.
     * @param m number of elements in Bloom filter.
     *
     * @return expectation of false probability.
     */
    public static boolean checkForLowFalseProbability(int k, int n, int m) {
        return calculateFalseProbability(k, n, m) > 0.2;
    }

}
