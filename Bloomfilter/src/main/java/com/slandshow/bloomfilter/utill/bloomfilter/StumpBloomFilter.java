package com.slandshow.bloomfilter.utill.bloomfilter;

import com.google.common.hash.Hashing;
import com.slandshow.bloomfilter.utill.probability.ProbabilityUtill;
import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StumpBloomFilter {

    private static final int DEFAULT_SIZE_OF_BLOOM_FILTER = 10;
    private static final int COUNT_OF_HASH_FUNCTIONS = 2;

    private boolean[] hashes;
    private int size;
    private int countOfElements;

    public StumpBloomFilter() {
        hashes = new boolean[DEFAULT_SIZE_OF_BLOOM_FILTER];
        size = DEFAULT_SIZE_OF_BLOOM_FILTER;
        countOfElements = 0;
    }

    public StumpBloomFilter(int hashesSize) {
        hashes = new boolean[hashesSize];
        size = hashesSize;
        countOfElements = 0;
    }

    public void insert(Object element) {
        hashes[generateMd5Hashcode(element.toString()) % hashes.length] = true;
        hashes[generateSha256Hashcode(element.toString()) % hashes.length] = true;
        countOfElements++;
    }

    public boolean search(Object element) {
        if (ProbabilityUtill.checkForLowFalseProbability(COUNT_OF_HASH_FUNCTIONS, hashes.length, countOfElements)) {
            return false;
        }

        return hashes[generateMd5Hashcode(element.toString()) % hashes.length]
                && hashes[generateSha256Hashcode(element.toString()) % hashes.length];
    }

    public boolean[] getHashes() {
        return Arrays.copyOf(hashes, hashes.length);
    }

    public int getSize() {
        return size;
    }

    private int generateMd5Hashcode(String seed) {
        int hash = DigestUtils.md5Hex(seed).hashCode();
        if (hash < 0) {
            return -hash;
        }

        return hash;
    }

    private int generateSha256Hashcode(String seed) {
        int hash = Hashing.sha256()
                .hashString(seed, StandardCharsets.UTF_8)
                .toString().hashCode();
        if (hash < 0) {
            return -hash;
        }

        return hash;
    }
}