package com.bignerdranch.android.beatbox;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by lchalouli on 04/09/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class SoundViewModelTest {

    @Mock
    private BeatBox mBeatBox;
    @Mock
    private Sound mSound = new Sound("assetPath");
    @InjectMocks
    private SoundViewModel mSubject = new SoundViewModel(mBeatBox);

    @Before
    public void setUp() throws Exception {
        mSubject.setSound(mSound);
    }

    @Test
    public void exposesSoundNameAsTitle() {
        assertThat(mSubject.getTitle(), is(mSound.getName()));
    }

    @Test
    public void callsBeatBoxPlayOnButtonClicked() {
        mSubject.onButtonClicked();

        Mockito.verify(mBeatBox).play(mSound);
    }
}