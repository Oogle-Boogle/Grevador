package com.client;

import com.client.definitions.GraphicsDefinition;
// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

final class Animable_Sub3 extends Renderable {

	public Animable_Sub3(int i, int j, int l, int i1, int j1, int k1, int l1) {
		aBoolean1567 = false;
		aSpotAnim_1568 = GraphicsDefinition.cache[i1];
		anInt1560 = i;
		anInt1561 = l1;
		anInt1562 = k1;
		anInt1563 = j1;
		anInt1564 = j + l;
		aBoolean1567 = false;
	}

	@Override
	public Model getRotatedModel() {
		Model model = aSpotAnim_1568.getModel();
		if (model == null)
			return null;
		int j = aSpotAnim_1568.aAnimation_407.primaryFrames[anInt1569];
		Model model_1 = new Model(true, Class36.method532(j), false, model);
		if (!aBoolean1567) {
			model_1.method469();
			model_1.method470(j);
			model_1.faceGroups = null;
			model_1.vertexGroups = null;
		}
		if (aSpotAnim_1568.resizeX != 128 || aSpotAnim_1568.resizeY != 128)
			model_1.method478(aSpotAnim_1568.resizeX, aSpotAnim_1568.resizeX,
					aSpotAnim_1568.resizeY);
		if (aSpotAnim_1568.rotation != 0) {
			if (aSpotAnim_1568.rotation == 90)
				model_1.method473();
			if (aSpotAnim_1568.rotation == 180) {
				model_1.method473();
				model_1.method473();
			}
			if (aSpotAnim_1568.rotation == 270) {
				model_1.method473();
				model_1.method473();
				model_1.method473();
			}
		}
		model_1.method479(64 + aSpotAnim_1568.ambience,
				850 + aSpotAnim_1568.contrast, -30, -50, -30, true);
		return model_1;
	}

	public void method454(int i) {
		for (anInt1570 += i; anInt1570 > aSpotAnim_1568.aAnimation_407.method258(anInt1569); ) {
			anInt1570 -= aSpotAnim_1568.aAnimation_407.method258(anInt1569) + 1;
			anInt1569++;
			if (anInt1569 >= aSpotAnim_1568.aAnimation_407.frameCount
					&& (anInt1569 < 0 || anInt1569 >= aSpotAnim_1568.aAnimation_407.frameCount)) {
				anInt1569 = 0;
				aBoolean1567 = true;
			}
		}

	}

	public final int anInt1560;
	public final int anInt1561;
	public final int anInt1562;
	public final int anInt1563;
	public final int anInt1564;
	public boolean aBoolean1567;
	private final GraphicsDefinition aSpotAnim_1568;
	private int anInt1569;
	private int anInt1570;
}