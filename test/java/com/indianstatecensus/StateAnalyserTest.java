package com.indianstatecensus;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class StateAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\Asus\\IdeaProjects\\IndianStateCensusAnalyser\\src\\test\\resources\\IndianStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "src\\main\\resources\\IndianStateCensusData.csv";


    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assertions.assertEquals(29, numOfRecords);
        } catch (CensusAnalyserException e) {
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianStateCSV_shouldReturnExactCount() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfStateCensus = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assertions.assertEquals(29, numOfStateCensus);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}