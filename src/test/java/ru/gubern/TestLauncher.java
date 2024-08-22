package ru.gubern;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;

public class TestLauncher {
    public static void main(String[] args) {
        var launcher = LauncherFactory.create();
        var summaryGeneratingListener = new SummaryGeneratingListener();
        var request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(DiscoverySelectors.selectPackage("ru.gubern.managers"))
                .build();
        launcher.execute(request, summaryGeneratingListener);
        try (var printerWriter = new PrintWriter(System.out)) {
            summaryGeneratingListener.getSummary().printTo(printerWriter);
        }
    }
}
