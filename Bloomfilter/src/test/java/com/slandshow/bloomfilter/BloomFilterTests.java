package com.slandshow.bloomfilter;

import com.slandshow.bloomfilter.utill.bloomfilter.StumpBloomFilter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BloomFilterTests {

    StumpBloomFilter stumpBloomFilter;

    @Before
    public void init() {
        stumpBloomFilter = new StumpBloomFilter();
    }

    @Test
    public void findElement() {
        stumpBloomFilter.insert("A");
        Assert.assertTrue(stumpBloomFilter.search("A"));
    }

    @Test
    public void failedToFindElement() {
        stumpBloomFilter.insert("A");
        Assert.assertFalse(stumpBloomFilter.search("B"));
    }

    @Test
    public void checkLowProbability() {
        stumpBloomFilter = new StumpBloomFilter(2);
        stumpBloomFilter.insert("A");
        Assert.assertFalse(stumpBloomFilter.search("A"));
    }

}
