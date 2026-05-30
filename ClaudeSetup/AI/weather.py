#!/usr/bin/env python3
import sys
import json
import urllib.request
import urllib.parse
import urllib.error

RESET  = "\033[0m"
BOLD   = "\033[1m"
CYAN   = "\033[36m"
YELLOW = "\033[33m"
GREEN  = "\033[32m"
BLUE   = "\033[34m"
RED    = "\033[31m"
WHITE  = "\033[37m"


def temp_color(temp_c: int) -> str:
    if temp_c <= 0:
        return BLUE
    if temp_c <= 10:
        return CYAN
    if temp_c <= 25:
        return GREEN
    if temp_c <= 35:
        return YELLOW
    return RED


def humidity_color(h: int) -> str:
    if h >= 80:
        return BLUE
    if h >= 50:
        return CYAN
    return GREEN


def fetch_weather(city: str) -> dict:
    encoded = urllib.parse.quote(city)
    url = f"https://wttr.in/{encoded}?format=j1"
    req = urllib.request.Request(url, headers={"User-Agent": "curl/7.0"})
    with urllib.request.urlopen(req, timeout=10) as resp:
        return json.loads(resp.read())


def display_weather(city: str, data: dict) -> None:
    current = data["current_condition"][0]
    area = data["nearest_area"][0]

    location = area["areaName"][0]["value"]
    country = area["country"][0]["value"]
    temp_c = current["temp_C"]
    temp_f = current["temp_F"]
    feels_c = current["FeelsLikeC"]
    feels_f = current["FeelsLikeF"]
    humidity = current["humidity"]
    wind_kmph = current["windspeedKmph"]
    description = current["weatherDesc"][0]["value"]
    visibility = current["visibility"]

    tc = temp_color(int(temp_c))
    hc = humidity_color(int(humidity))
    wind = int(wind_kmph)
    wc = RED if wind >= 50 else YELLOW if wind >= 20 else GREEN

    print(f"\n{BOLD}{CYAN}Weather for {location}, {country}{RESET}")
    print(CYAN + "=" * 40 + RESET)
    print(f"{WHITE}Condition:  {RESET} {BOLD}{description}{RESET}")
    print(f"{WHITE}Temperature:{RESET} {tc}{BOLD}{temp_c}°C / {temp_f}°F{RESET}")
    print(f"{WHITE}Feels like: {RESET} {tc}{feels_c}°C / {feels_f}°F{RESET}")
    print(f"{WHITE}Humidity:   {RESET} {hc}{humidity}%{RESET}")
    print(f"{WHITE}Wind speed: {RESET} {wc}{wind_kmph} km/h{RESET}")
    print(f"{WHITE}Visibility: {RESET} {GREEN}{visibility} km{RESET}")


def main():
    city = " ".join(sys.argv[1:]) if len(sys.argv) > 1 else "London"
    try:
        data = fetch_weather(city)
        display_weather(city, data)
    except urllib.error.HTTPError as e:
        print(f"Error: could not fetch weather ({e.code})")
        sys.exit(1)
    except (KeyError, IndexError):
        print("Error: unexpected response format")
        sys.exit(1)


if __name__ == "__main__":
    main()
