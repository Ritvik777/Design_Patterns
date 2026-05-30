# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Running the script

```bash
python3 weather.py "City Name"   # fetch weather for a city
python3 weather.py               # defaults to London
```

## Architecture

`weather.py` is a single-file CLI tool with no external dependencies (stdlib only):

- **`fetch_weather(city)`** — URL-encodes the city name, hits `https://wttr.in/<city>?format=j1`, returns parsed JSON.
- **`display_weather(city, data)`** — extracts fields from `data["current_condition"][0]` and `data["nearest_area"][0]`, then prints ANSI color-coded output.
- Color helpers (`temp_color`, `humidity_color`) map numeric thresholds to ANSI escape codes defined as module-level constants.
