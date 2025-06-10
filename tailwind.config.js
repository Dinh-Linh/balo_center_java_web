/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/main/resources/templates/**/*.html",
    "./src/main/resources/static/**/*.js", // If you have JS files that might use Tailwind classes
  ],
  theme: {
    extend: {
      colors: {
        'custom-orange': '#eb6c28',
        'custom-brown': '#1b120e',
        'custom-light-brown': '#7f5e53',
        'custom-beige': '#fef5f0',
      },
      fontFamily: {
        sans: ['Inter var', 'sans-serif'],
      },
    },
  },
  plugins: [
    require('@tailwindcss/forms'),
    require('@tailwindcss/typography'),
    require('@tailwindcss/aspect-ratio'),
  ],
}
