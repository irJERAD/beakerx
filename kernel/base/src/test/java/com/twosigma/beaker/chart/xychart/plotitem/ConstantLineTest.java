/*
 *  Copyright 2014 TWO SIGMA OPEN SOURCE, LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.twosigma.beaker.chart.xychart.plotitem;

import com.twosigma.beaker.chart.Color;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Date;

public class ConstantLineTest {

  @Test
  public void createConstantLineByEmptyConstructor_hasXandYisNull() {
    //when
    ConstantLine constantLine = new ConstantLine();
    //then
    Assertions.assertThat(constantLine.getX()).isNull();
    Assertions.assertThat(constantLine.getY()).isNull();
  }

  @Test
  public void setXWithDateParam_constantLineHasNumberX() {
    //when
    ConstantLine constantLine = new ConstantLine();
    constantLine.setX(new Date());
    //then
    Assertions.assertThat(constantLine.getX() instanceof Number).isTrue();
  }

  @Test
  public void setColorWithAwtColor_constantLineHasBeakerColor() {
    //when
    ConstantLine constantLine = new ConstantLine();
    constantLine.setColor(java.awt.Color.GREEN);
    //then
    Assertions.assertThat(constantLine.getColor() instanceof Color).isTrue();
  }
}
