package com.hanyasoftware.android.antrianbengkel.repository.ultils;

import java.util.Collection;

public interface ILayerDataTransformer<F, T> {
    T transform(F from);

    Collection<T> transform(Collection<F> from);
}
