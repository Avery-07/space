package service;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.StellarSystem;
import model.celestial.*;
import model.core.CelestialBody;
import model.core.OrbitingBody;
import model.type.PlanetType;

public class SystemRenderer {

    private final Canvas canvas;
    private final GraphicsContext gc;
    private final StellarSystem system;
    private double zoom = 1.0;
    private double originX, originY;

    public SystemRenderer(Canvas canvas, StellarSystem system) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        this.system = system;
    }

    public void start() {
        new AnimationTimer() {
            private long lastTime = System.nanoTime();

            @Override
            public void handle(long now) {
                double deltaTime = (now - lastTime) / 1_000_000_000.0;
                lastTime = now;

                // 1. Update Logic (1.0 = real time, 100.0 = fast forward)
                system.update(deltaTime, 50.0);

                // 2. Draw Logic
                draw();
            }
        }.start();
    }

    private void draw() {
        // Clear screen
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        originX = canvas.getWidth() / 2;
        originY = canvas.getHeight() / 2;

        drawBody(system.getStar());
    }

    private void drawBody(CelestialBody body) {
        // Calculate screen position: Screen = Origin + (ModelCoord * Zoom)
        double screenX = originX + body.getPosition().X;
        double screenY = originY + body.getPosition().Y;
        double drawSize = body.getSize();

        // Draw Orbit Path if it's an orbiting body
        if (body instanceof OrbitingBody ob) {
            gc.setStroke(Color.web("#333333"));
            gc.setLineWidth(1);
            double orbitRadius = ob.getOrbitalRadius();
            gc.strokeOval(originX + ob.getParent().getPosition().X - orbitRadius, originY + ob.getParent().getPosition().Y - orbitRadius, orbitRadius * 2, orbitRadius * 2);
        }

        // Draw the Body
        gc.setFill(getColorForBody(body));
        gc.fillOval(screenX - drawSize / 2, screenY - drawSize / 2, drawSize, drawSize);

        // Recursive Draw for children (Planets -> Moons)
        if (body instanceof Star star) {
            for (var p : star.getSatellites()) drawBody(p);
        } else if (body instanceof Planet planet) {
            for (var m : planet.getSatellites()) drawBody(m);
        }
    }

    private Color getColorForBody(CelestialBody body) {
        if (body instanceof Star) return Color.YELLOW;
        if (body instanceof Planet planet && planet.getType() == PlanetType.GASEOUS ) return Color.LIGHTBLUE;
        if (body instanceof Planet planet && planet.getType() == PlanetType.ROCKY ) return Color.ORANGE;
        if (body instanceof Moon) return Color.LIGHTGRAY;
        if (body instanceof AsteroidBelt) return Color.LIGHTGRAY;
        return Color.WHITE;
    }

    public void setZoom(double zoom) { this.zoom = zoom; }
}