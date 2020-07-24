package com.niluogege.debug;

import android.content.Context;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockUnitTest {
    private static final String mockAppName="wahh";

    @Mock
    Context mMockContext;

    @Test
    public void readStringFromContext_LocalizedString(){
        Mockito.when(mMockContext.getString(R.string.app_name)).thenReturn(mockAppName);
        Assert.assertThat(mMockContext.getString(R.string.app_name), Is.is(mockAppName));

        Mockito.when(mMockContext.getPackageName()).thenReturn("com.jdqm.androidunittest");
        System.out.println(mMockContext.getPackageName());
    }
}
