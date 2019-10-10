package com.lightninglambdas;

import com.amazonaws.services.lambda.runtime.events.S3Event;

public class Unit_g43grewgrewf_root_0 {
  private final Unit_g43grewgrewf_root_0_0 unit_g43grewgrewf_root_0_0;

  private final UserExporter userExporter;

  public Unit_g43grewgrewf_root_0(
      final Unit_g43grewgrewf_root_0_0 unit_g43grewgrewf_root_0_0,
      final UserExporter userExporter) {
    this.unit_g43grewgrewf_root_0_0 = unit_g43grewgrewf_root_0_0;
    this.userExporter = userExporter;
  }

  public void execute(final S3Event s3Event) {
    final String fileName = unit_g43grewgrewf_root_0_0.execute(s3Event);
    userExporter.execute(fileName);
  }
}
