package com.indianstatecensus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class StateAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "src\\test\\resources\\IndianStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "src\\main\\resources\\IndianStateCensusData.csv";
    private static final String INDIAN_CENSUS_CSV_WRONG_DELIMITER = "src\\main\\resources\\IndiaStateCensusDataWrongDelimiter.csv";
    private static final String INDIAN_CENSUS_CSV_MISSING = "src\\test\\resources\\IndiaStateCensusDataMissingHeader.csv";
    private static final String INDIAN_CSV_STATE_PATH = "src\\test\\resources\\IndianStateCode.csv";
    private static final String WRONG_CSV_STATE_PATH = "src\\main\\resources\\IndianStateCode.csv";
    private static final String STATE_CODE_CSV_WRONG_DELIMITER = "src\\main\\resources\\IndiaStateCodeDataWrongDelimiter.csv";

    @Test
    public void givenIndianCensusCSVFile_ReturnsCorrectRecords() {
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
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES, e.type);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenEmptyCsvFile_ShouldReturnCustomExceptionType() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_WRONG_DELIMITER);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenWrongDelimiter_InIndiaCensusData_ShouldReturnCustomExceptionType() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_WRONG_DELIMITER);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMissingHeader_InIndiaCensusData_ShouldReturnCustomExceptionType() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_MISSING);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianStateCodeCSVFile_ReturnsCorrectRecords() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfStateCode = censusAnalyser.loadIndiaCensusData(INDIAN_CSV_STATE_PATH);
            Assertions.assertEquals(37, numOfStateCode);
        } catch (CensusAnalyserException e) {
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenStateCodeData_WithWrongFile_ShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_STATE_PATH);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenEmptyStateCodeCsvFile_ShouldReturnCustomExceptionType() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            censusAnalyser.loadIndiaCensusData(STATE_CODE_CSV_WRONG_DELIMITER);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}