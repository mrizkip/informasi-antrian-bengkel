package com.hanyasoftware.android.antrianbengkel.repository.ultils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseLayerDataTransformer<F, T> implements ILayerDataTransformer<F, T> {
    @Override
    public List<T> transform(Collection<F> from) {
        List<T> transformed = new ArrayList<>(from.size());

        for (F fromObject : from) {
            transformed.add(transform(fromObject));
        }

        return transformed;
    }
}