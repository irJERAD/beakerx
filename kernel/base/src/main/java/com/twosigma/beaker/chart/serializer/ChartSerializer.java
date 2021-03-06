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
package com.twosigma.beaker.chart.serializer;


import com.twosigma.beaker.chart.Chart;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public abstract class ChartSerializer<T extends Chart> extends ObservableChartSerializer<T> {

  public static final String CHART_TITLE = "chart_title";
  public static final String LEGEND_POSITION = "legend_position";
  public static final String SHOW_LEGEND = "show_legend";
  public static final String USE_TOOL_TIP = "use_tool_tip";
  public static final String INIT_WIDTH = "init_width";
  public static final String INIT_HEIGHT = "init_height";

  protected void serialize(T chart, JsonGenerator jgen) throws IOException {

    super.serialize(chart, jgen);

    String type = chart.getClass().getSimpleName();
    if ("SimpleTimePlot".equals(type)){
      jgen.writeObjectField("type", "TimePlot");
    }else {
      jgen.writeObjectField("type", type);
    }

    jgen.writeObjectField(INIT_WIDTH, chart.getInitWidth());
    jgen.writeObjectField(INIT_HEIGHT, chart.getInitHeight());
    jgen.writeObjectField(CHART_TITLE, chart.getTitle());
    jgen.writeObjectField(SHOW_LEGEND, chart.getShowLegend());
    jgen.writeObjectField(USE_TOOL_TIP, chart.getUseToolTip());
    jgen.writeObjectField(LEGEND_POSITION, chart.getLegendPosition());
    jgen.writeObjectField("legend_layout", chart.getLegendLayout());
    jgen.writeObjectField("custom_styles", chart.getCustomStyles());
    jgen.writeObjectField("element_styles", chart.getElementStyles());
  }
}
