package com.github.deen13.ui;

import static org.hamcrest.Matchers.is;
import static org.loadui.testfx.Assertions.verifyThat;
import static org.loadui.testfx.controls.ListViews.numberOfRowsIn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import de.roskenet.jfxsupport.test.GuiTest;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NewsViewTest extends GuiTest {

	@MockBean private FakeNewsService fakeService;

	@Override
	public void init() throws Exception {
		init(NewsView.class);
	}

	@Test
	public void test() {
		verifyThat(numberOfRowsIn(".list-view"), is(0));
	}

}
